package mx.datafit.escolarex.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import java.util.ArrayList;
import mx.datafit.escolarex.R;
import mx.datafit.escolarex.adapters.MenuDataAdapter;
import mx.datafit.escolarex.entities.MenuItem;
import mx.datafit.escolarex.listeners.RecyclerItemClickListener;


public class MainMenuActivity extends AppCompatActivity {
    private static final String TAG = "MainMenuActivity";

    private final String recyclerViewTitleText[] = {
            "Estado de cuenta",
            "Tareas",
            "Perfil",
            "Comedor",
            "Calificaciones",
            "Salir"
    };

    private final int recyclerViewImages[] = {
            R.drawable.ic_account,
            R.drawable.ic_homeworks,
            R.drawable.ic_profile,
            R.drawable.ic_dinning,
            R.drawable.ic_ratings,
            R.drawable.ic_off

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initRecyclerViews();
    }

    public String getRotation(Context context) {
        final int rotation = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE))
                .getDefaultDisplay()
                .getOrientation();

        switch (rotation) {
            case Surface.ROTATION_0:
            case Surface.ROTATION_180:
                return "vertical";
            case Surface.ROTATION_90:
            case Surface.ROTATION_270:
                return "horizontal";
            default:
                return "horizontal";
        }
    }


    private void initRecyclerViews() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        int mNoOfColumns;

        if (getRotation(getApplicationContext()).equals("vertical")) {
            mNoOfColumns = 2;
        } else {
            mNoOfColumns = 3;
        }

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(
                getApplicationContext(),
                mNoOfColumns
        );
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<MenuItem> items = prepareData();
        MenuDataAdapter mAdapter = new MenuDataAdapter(getApplicationContext(), items);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        Intent accountStatus = new Intent(getApplicationContext(), AccountStatusActivity.class);
                        startActivity(accountStatus);
                        overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
                        break;
                    case 1:
                        Intent homeworks = new Intent(getApplicationContext(), HomeworkActivity.class);
                        startActivity(homeworks);
                        overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
                        break;
                    case 2:
                        Intent studentProfile = new Intent(getApplicationContext(), StudentProfileActivity.class);
                        startActivity(studentProfile);
                        overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
                        break;
                    case 3:
                        Intent cateen = new Intent(getApplicationContext(), CateenActivity.class);
                        startActivity(cateen);
                        overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
                        break;
                    case 4:
                        Toast.makeText(view.getContext(), "position= " + position, Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(view.getContext(), "position= " + position, Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(view.getContext(), "position= " + position, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }));
    }

    private ArrayList<MenuItem> prepareData() {
        ArrayList<MenuItem> menu = new ArrayList<>();

        for (int i = 0; i < recyclerViewTitleText.length; i++) {
            MenuItem item = new MenuItem();
            item.setItemName(recyclerViewTitleText[i]);
            item.setRecyclerViewImage(recyclerViewImages[i]);
            menu.add(item);
        }

        return menu;
    }
}
