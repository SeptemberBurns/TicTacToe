package com.october.ticatactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Turns player1;
    Turns player2;
    private boolean TRN_Owner;
    private boolean figure;
    Button chngdbtn;

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
        Toast toast = Toast.makeText(getApplicationContext(),"test " + view.getTag(),Toast.LENGTH_SHORT);
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

    public void Pressed(View view){

        updateUI(view);
        if(player1.ifWinCombo())
            showTag(view);
        if(player2.ifWinCombo())
            showTag(view);

    }

}
