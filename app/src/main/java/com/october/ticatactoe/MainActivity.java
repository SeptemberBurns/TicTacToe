package com.october.ticatactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Turns player1;
    Turns player2;
    private boolean TRN_Owner;
    private boolean figure;
    Button chngdbtn;
    Toast toast;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.restart:
                restartApp();
                break;
        }
        return true;
    }

    private void switchFigure(){

        figure = !figure;
        TRN_Owner = !TRN_Owner;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1 = new Turns();
        player2 = new Turns();
        figure = true;
    }

    public void showTag(View view){
        toast = Toast.makeText(getApplicationContext(),"test " + view.getTag(),Toast.LENGTH_SHORT);
        toast.show();

    }

    private void updateUI(View view){

        chngdbtn = (Button) view;

        if(figure)
            player1.saveTurn(String.valueOf(view.getTag()));
        else
            player2.saveTurn(String.valueOf(view.getTag()));


        if(figure)
            chngdbtn.setText("x");
        else
            chngdbtn.setText("0");

        switchFigure();
        chngdbtn.setEnabled(false);

    }

    public void showMessage(String msg){
        toast = Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT);
        toast.show();
    }

    public void restartApp(){
        startActivity(new Intent(MainActivity.this,MainActivity.class));
        finish();
    }

    public void endGame(String player){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(player + " have won, restart?");
        alertDialogBuilder
                //.setMessage("Click yes to exit!")
                .setCancelable(false)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                restartApp();
                            }
                        })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public void Pressed(View view){

        updateUI(view);
        if(player1.ifWinCombo())
            endGame("Player 1 (X)");
        if(player2.ifWinCombo())
            endGame("Player 2 (0)");
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Exit Game?");
        alertDialogBuilder
                .setMessage("Click yes to exit!")
                .setCancelable(false)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
