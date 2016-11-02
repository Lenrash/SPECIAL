package ga.leliadoura.dam2.special;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import java.nio.charset.CharacterCodingException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int pointsLeft = 21;

    private int strength = 1;
    private int perception = 1;
    private int endurance = 1;
    private int charisma = 1;
    private int intelligence = 1;
    private int agility = 1;
    private int luck = 1;

    private String name, gender, rifleman, barter, medic;

    private Button[] bplus = new Button[7];
    private Button[] bminus = new Button[7];
    private Button summary;
    private TextView[] tview = new TextView[7];
    private TextView pointL, textname;
    private RadioButton rbmale, rbfemale;
    private CheckBox cb_rifleman, cb_barter, cb_medic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();
        refreshText();
    }


    @Override
    public void onClick(View v) {

        if (pointsLeft >= 0) {
            buttonMinusPressed(v);
        }

        if (pointsLeft > 0 && pointsLeft <= 21) {
            buttonPlusPressed(v);
        }

        if(v.getId() == R.id.summary){
            startActivity(intentForSummary());
        }
        refreshText();

    }

    private void inicializar(){
        bminus[0] = (Button) findViewById(R.id.bminus_str);
        bminus[1] = (Button) findViewById(R.id.bminus_perc);
        bminus[2] = (Button) findViewById(R.id.bminus_endur);
        bminus[3] = (Button) findViewById(R.id.bminus_char);
        bminus[4] = (Button) findViewById(R.id.bminus_int);
        bminus[5] = (Button) findViewById(R.id.bminus_agi);
        bminus[6] = (Button) findViewById(R.id.bminus_luck);

        bplus[0] = (Button) findViewById(R.id.bplus_str);
        bplus[1] = (Button) findViewById(R.id.bplus_perc);
        bplus[2] = (Button) findViewById(R.id.bplus_endur);
        bplus[3] = (Button) findViewById(R.id.bplus_char);
        bplus[4] = (Button) findViewById(R.id.bplus_int);
        bplus[5] = (Button) findViewById(R.id.bplus_agi);
        bplus[6] = (Button) findViewById(R.id.bplus_luck);

        summary = (Button)findViewById(R.id.summary);

        tview[0] = (TextView) findViewById(R.id.text_strenght);
        tview[1] = (TextView) findViewById(R.id.text_perception);
        tview[2] = (TextView) findViewById(R.id.text_endurance);
        tview[3] = (TextView) findViewById(R.id.text_charisma);
        tview[4] = (TextView) findViewById(R.id.text_intelligence);
        tview[5] = (TextView) findViewById(R.id.text_agility);
        tview[6] = (TextView) findViewById(R.id.text_luck);

        bminus[0].setOnClickListener(this);
        bminus[1].setOnClickListener(this);
        bminus[2].setOnClickListener(this);
        bminus[3].setOnClickListener(this);
        bminus[4].setOnClickListener(this);
        bminus[5].setOnClickListener(this);
        bminus[6].setOnClickListener(this);

        bplus[0].setOnClickListener(this);
        bplus[1].setOnClickListener(this);
        bplus[2].setOnClickListener(this);
        bplus[3].setOnClickListener(this);
        bplus[4].setOnClickListener(this);
        bplus[5].setOnClickListener(this);
        bplus[6].setOnClickListener(this);

        summary.setOnClickListener(this);

        pointL = (TextView) findViewById(R.id.points_left);
        textname = (TextView) findViewById(R.id.text_name);

        rbmale = (RadioButton) findViewById(R.id.radio_male);
        rbfemale = (RadioButton) findViewById(R.id.radio_female);

        cb_rifleman = (CheckBox) findViewById(R.id.check_rifleman);
        cb_barter = (CheckBox) findViewById(R.id.check_barter);
        cb_medic = (CheckBox) findViewById(R.id.check_medic);
    }

    private void buttonMinusPressed(View v){
        switch (v.getId()) {
            case R.id.bminus_str:
                if (strength > 1)
                    resta(R.id.bminus_str);
                break;

            case R.id.bminus_perc:
                if (perception > 1)
                    resta(R.id.bminus_perc);
                break;

            case R.id.bminus_endur:
                if (endurance > 1)
                    resta(R.id.bminus_endur);
                break;

            case R.id.bminus_char:
                if (charisma > 1)
                    resta(R.id.bminus_char);
                break;

            case R.id.bminus_int:
                if (intelligence > 1)
                    resta(R.id.bminus_int);
                break;

            case R.id.bminus_agi:
                if (agility > 1)
                    resta(R.id.bminus_agi);
                break;

            case R.id.bminus_luck:
                if (luck > 1)
                    resta(R.id.bminus_luck);
                break;




        }
    }

    private void buttonPlusPressed(View v){
        switch(v.getId()) {
            case R.id.bplus_str:
                if (strength < 10)
                    suma(R.id.bplus_str);
                break;

            case R.id.bplus_perc:
                if (perception < 10)
                    suma(R.id.bplus_perc);
                break;

            case R.id.bplus_endur:
                if (endurance < 10)
                    suma(R.id.bplus_endur);
                break;

            case R.id.bplus_char:
                if (charisma < 10)
                    suma(R.id.bplus_char);
                break;

            case R.id.bplus_int:
                if (intelligence < 10)
                    suma(R.id.bplus_int);
                break;

            case R.id.bplus_agi:
                if (agility < 10)
                    suma(R.id.bplus_agi);
                break;

            case R.id.bplus_luck:
                if (luck < 10)
                    suma(R.id.bplus_luck);
                break;
        }
    }

    private void suma(int id) {
        switch (id) {
            case R.id.bplus_str:
                strength++;
                break;
            case R.id.bplus_perc:
                perception++;
                break;
            case R.id.bplus_endur:
                endurance++;
                break;
            case R.id.bplus_char:
                charisma++;
                break;
            case R.id.bplus_int:
                intelligence++;
                break;
            case R.id.bplus_agi:
                agility++;
                break;
            case R.id.bplus_luck:
                luck++;
                break;
        }
        pointsLeft--;
    }

    private void resta(int id) {
        switch (id) {
            case R.id.bminus_str:
                strength--;
                break;
            case R.id.bminus_perc:
                perception--;
                break;
            case R.id.bminus_endur:
                endurance--;
                break;
            case R.id.bminus_char:
                charisma--;
                break;
            case R.id.bminus_int:
                intelligence--;
                break;
            case R.id.bminus_agi:
                agility--;
                break;
            case R.id.bminus_luck:
                luck--;
                break;
        }
        pointsLeft++;
    }

    private void refreshText(){
        pointL.setText(getText(R.string.pointsleft) + " " + String.valueOf(pointsLeft));
        tview[0].setText(getText(R.string.strength) + " " + String.valueOf(strength));
        tview[1].setText(getText(R.string.perception) + " " + String.valueOf(perception));
        tview[2].setText(getText(R.string.endurance) + " " + String.valueOf(endurance));
        tview[3].setText(getText(R.string.charisma) + " " + String.valueOf(charisma));
        tview[4].setText(getText(R.string.intelligence) + " " + String.valueOf(intelligence));
        tview[5].setText(getText(R.string.agility) + " " + String.valueOf(agility));
        tview[6].setText(getText(R.string.luck) + " " + String.valueOf(luck));
    }

    private Intent intentForSummary(){
        Intent intent = new Intent(this, Summary.class);

        intent.putExtra("strength", strength);
        intent.putExtra("perception", perception);
        intent.putExtra("endurance", endurance);
        intent.putExtra("charisma", charisma);
        intent.putExtra("intelligence", intelligence);
        intent.putExtra("agility", agility);
        intent.putExtra("luck", luck);

        name = String.valueOf(textname.getText());
        intent.putExtra("name", name);

        asignGender();
        intent.putExtra("gender", gender);

        checkPerks();

        intent.putExtra("rifleman", rifleman);
        intent.putExtra("barter", barter);
        intent.putExtra("medic", medic);

        return intent;
    }

    private void asignGender(){
        if(rbmale.isChecked())
            gender = String.valueOf(rbmale.getText());
        if(rbfemale.isChecked())
            gender = String.valueOf(rbfemale.getText());
    }

    private void checkPerks(){

        if (cb_rifleman.isChecked()) {
           rifleman = String.valueOf(cb_rifleman.getText());
        }

        if (cb_barter.isChecked()){
           barter = String.valueOf(cb_barter.getText());
        }

        if (cb_medic.isChecked()){
           medic = String.valueOf(cb_medic.getText());
        }

    }

}

