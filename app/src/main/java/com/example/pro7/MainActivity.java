package com.example.pro7;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    Button closeButton;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        closeButton = (Button) findViewById(R.id.button);
        builder = new AlertDialog.Builder(this);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Uncomment the below code to Set the message and titlefrom the strings.xml file
                // builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
                //Setting message manually and performing action on buttonclick
                builder.setMessage("Do you want to close this application ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new
                                DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int
                                            id) {
                                        finish();
                                        Toast.makeText(getApplicationContext(),
                                                "you choose yes action for alertbox",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .setNegativeButton("No", new
                                DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int
                                            id) {
                                        // Action for 'NO' Button
                                        dialog.cancel();
                                        Toast.makeText(getApplicationContext(),
                                                "you choose no action for alertbox",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("AlertDialogExample");
                alert.show();
            }
        });
    }
}
