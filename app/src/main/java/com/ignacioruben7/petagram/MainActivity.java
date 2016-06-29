package com.ignacioruben7.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ignacioruben7.petagram.adapter.MascotaAdapter;
import com.ignacioruben7.petagram.adapter.PageAdapter;
import com.ignacioruben7.petagram.fragment.FragmentPrincipal;
import com.ignacioruben7.petagram.fragment.PerfilMascota;
import com.ignacioruben7.petagram.menu_option.AboutAutor;
import com.ignacioruben7.petagram.menu_option.FormularioContacto;
import com.ignacioruben7.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intent = new Intent(this,FormularioContacto.class);
                startActivity(intent);
                break;
            case R.id.mAbout:
                Intent i = new Intent(this,AboutAutor.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new FragmentPrincipal());
        fragments.add(new PerfilMascota());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_principal);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perfil);
    }


    public void iniciarFavoritos(View view){
        Intent intent = new Intent(this,ListadoMascotas.class);
        startActivity(intent);
    }
}
