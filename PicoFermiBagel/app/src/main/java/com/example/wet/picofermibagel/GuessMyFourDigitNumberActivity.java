package com.example.wet.picofermibagel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.Random;
import java.util.ArrayList;

public class GuessMyFourDigitNumberActivity extends AppCompatActivity {
    private Random r;
    private ArrayList<String> randomNoList = new ArrayList<>();
    private int nextRandomNo1;;
    private ListView fourDigitListView;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_digit);
        r = new Random();
        nextRandomNo1 = r.nextInt(10000 - 1000);
        randomNoList.add(String.valueOf(nextRandomNo1));
        Button sumbitbuttonfourdigit = (Button) this.findViewById(R.id.submit_button1);
        sumbitbuttonfourdigit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText yourResponse = (EditText) GuessMyFourDigitNumberActivity.this.findViewById(R.id.your_four_digit_number_id);
                int yourFourDigitNumberGuess = Integer.parseInt(yourResponse.getText().toString().trim());

                if(nextRandomNo1 ==yourFourDigitNumberGuess)
                {
                    Toast.makeText(GuessMyFourDigitNumberActivity.this, "You Won!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(GuessMyFourDigitNumberActivity.this, "You Lost, The Number was "+nextRandomNo1 , Toast.LENGTH_SHORT).show();


                }
                nextRandomNo1 = r.nextInt(10000 - 1000);
                randomNoList.add(String.valueOf(nextRandomNo1));

                adapter.notifyDataSetChanged();
            }

        });
        fourDigitListView = (ListView)this.findViewById(R.id.random_listview);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, randomNoList);
        fourDigitListView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
