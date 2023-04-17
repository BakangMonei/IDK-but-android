package com.neizatheedev.project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.neizatheedev.project1.chatApp.CallsFragment;
import com.neizatheedev.project1.chatApp.CameraActivity;
import com.neizatheedev.project1.chatApp.ChatFragment;
import com.neizatheedev.project1.chatApp.StatusFragment;

public class MyAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_app);

        Button ChatsButton = (Button) findViewById(R.id.ChatsButton);
        Button statusButton = (Button) findViewById(R.id.statusButton);
        Button callsButton = (Button) findViewById(R.id.callsButton);
        ImageView cam = (ImageView) findViewById(R.id.cameraImageView);
        ImageView searchImageView = (ImageView) findViewById(R.id.searchImageView);
        ImageView menuImageView = (ImageView) findViewById(R.id.menuImageView);

        menuImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initializing the popup menu and giving the reference as current context
                PopupMenu popupMenu = new PopupMenu(MyAppActivity.this, menuImageView);

                // Inflating popup menu from popup_menu.xml file
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        // Toast message on menu item clicked
                        Toast.makeText(MyAppActivity.this, "You Clicked " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        // Intent x = new Intent(IndexActivity.this, menuItem.getClass());
                        return true;
                    }
                });
                // Showing the popup menu
                popupMenu.show();
            }
        });

        cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyAppActivity.this, "Camera", Toast.LENGTH_SHORT).show();
                Intent cameraView = new Intent(MyAppActivity.this, CameraActivity.class);
                startActivity(cameraView);
            }
        });

        ChatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView18, ChatFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });
        statusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView18, StatusFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });

        callsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView18, CallsFragment.class, null).setReorderingAllowed(true).addToBackStack("name").commit();
            }
        });
    }
}