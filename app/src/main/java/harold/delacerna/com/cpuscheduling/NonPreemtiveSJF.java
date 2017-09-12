package harold.delacerna.com.cpuscheduling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NonPreemtiveSJF extends AppCompatActivity {

    EditText eBT1, eBT2, eBT3, eBT4, eAT1, eAT2, eAT3, eAT4;
    TextView vWT1, vWT2, vWT3, vWT4, vTT1, vTT2, vTT3, vTT4, vAvgWT, vAvgTT;
    TextView pro1, pro2 ,pro3 ,pro4;


    double avgWT, avgTT;
    double b1, b2, b3, b4, result, result1, tt1, tt2,tt3,tt4;
    String etbt1, etbt2, etbt3, etbt4, dbt2, dbt3, dbt4, avg, avg2;
    double a1, a2, a3, a4;
    String etAt1, etAt2, etAt3, etAt4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_preemtive_sjf);
        findViews();
    }

    private void findViews() {
        //burst time
        eBT1 = (EditText) findViewById(R.id.firstBT);
        eBT2 = (EditText) findViewById(R.id.secBT);
        eBT3 = (EditText) findViewById(R.id.thirdBT);
        eBT4 = (EditText) findViewById(R.id.forthBT);
        // arrival time
        eAT1 = (EditText) findViewById(R.id.firstAT);
        eAT2 = (EditText) findViewById(R.id.secAT);
        eAT3 = (EditText) findViewById(R.id.thirdAT);
        eAT4 = (EditText) findViewById(R.id.forthAT);
        // waiting time
        vWT1 = (TextView) findViewById(R.id.firstWT);
        vWT2 = (TextView) findViewById(R.id.secWT);
        vWT3 = (TextView) findViewById(R.id.thirdWT);
        vWT4 = (TextView) findViewById(R.id.forthWT);
        // turnaround time
        vTT1 = (TextView) findViewById(R.id.firstTT);
        vTT2 = (TextView) findViewById(R.id.secTT);
        vTT3 = (TextView) findViewById(R.id.thirdTT);
        vTT4 = (TextView) findViewById(R.id.forthTT);

        pro1 = (TextView) findViewById(R.id.p1);
        pro2 = (TextView) findViewById(R.id.p2);
        pro3 = (TextView) findViewById(R.id.p3);
        pro4 = (TextView) findViewById(R.id.p4);



        vAvgWT = (TextView) findViewById(R.id.tvAvgWT);
        vAvgTT = (TextView) findViewById(R.id.tvAvgTT);


    }

    public void ComputeSJF(View view) {
        waitingTime();
        turnaroundTime();
    }

    private void turnaroundTime() {
        etbt1 = eBT1.getText().toString();
        etbt2 = eBT2.getText().toString();
        etbt3 = eBT3.getText().toString();
        etbt4 = eBT4.getText().toString();

        b1 = Double.parseDouble(etbt1);
        b2 = Double.parseDouble(etbt2);
        b3 = Double.parseDouble(etbt3);
        b4 = Double.parseDouble(etbt4);
        //ARRIVAL TIME
        etAt1 = eAT1.getText().toString();
        etAt2 = eAT2.getText().toString();
        etAt3 = eAT3.getText().toString();
        etAt4 = eAT4.getText().toString();
        a1 = Double.parseDouble(etAt1);
        a2 = Double.parseDouble(etAt2);
        a3 = Double.parseDouble(etAt3);
        a4 = Double.parseDouble(etAt4);


        if (b1 > a2 || b1 > a3 || b1 > a4) {
           tt1 = b1 - a1;
            dbt2 = Integer.toString((int) tt1);
            vTT1.setText(dbt2);
            if(b2 < b3 && b2 < b4){
                tt2 = b1+b2 - a2;
                dbt3 = Integer.toString((int) tt2);
                vTT2.setText(dbt3);
                if((b1+b2) > b3 || (b1+b2) > b4){
                    if(b3 < b4 && (b3 == b4 || a3 < a4)){
                        tt3 = (b1+b2+b3)- a3;
                        dbt4 = Integer.toString((int) tt3);
                        vTT3.setText(dbt4);
                        // avgWaiting time
                        avgTT = ((b1-a1) + (result-a3) + (result1-a2) + (b1+b2+b3+b4-a4)) / 4;
                        avg = String.format("%,.2f", +avgTT);
                        vAvgTT.setText(avg);
                        tt4 = (b1+b2+b3+b4)- a4;
                        dbt4 = Integer.toString((int) tt4);
                        vTT4.setText(dbt4);
                    }
                    else {
                        tt4 = (b1+b2+b4) - a4;
                        dbt4 = Integer.toString((int) tt4);
                        vTT3.setText(dbt4);
                        // avgWaiting time
                        avgTT = ((b1-a1) + (result-a3) + (result1-a2) + (b1+b2+b3+b4-a4)) / 4;
                        avg = String.format("%,.2f", +avgTT);
                        vAvgTT.setText(avg);
                        tt3 = (b1+b2+b3+b4)- a3;
                        dbt4 = Integer.toString((int) tt3);
                        vTT4.setText(dbt4);

                    }
                }
                else if(b3 < b4 && (b3 == b4 || a3 < a4)){
                    tt3 = (b1+b2+b3)- a3;
                    dbt4 = Integer.toString((int) tt3);
                    vTT3.setText(dbt4);
                    // avgWaiting time
                    avgTT = ((b1-a1) + (result-a3) + (result1-a2) + (b1+b2+b3+b4-a4)) / 4;
                    avg = String.format("%,.2f", +avgTT);
                    vAvgTT.setText(avg);
                    tt4 = (b1+b2+b3+b4)- a4;
                    dbt4 = Integer.toString((int) tt4);
                    vTT4.setText(dbt4);
                }
                else if (b4 < b3 && (b4 == b3 || a4 < a3)){
                    tt4 = (b1+b2+b4) - a4;
                    dbt4 = Integer.toString((int) tt4);
                    vTT3.setText(dbt4);
                    // avgWaiting time
                    avgTT = ((b1-a1) + (result-a3) + (result1-a2) + (b1+b2+b3+b4-a4)) / 4;
                    avg = String.format("%,.2f", +avgTT);
                    vAvgTT.setText(avg);
                    tt3 = (b1+b2+b3+b4)- a3;
                    dbt4 = Integer.toString((int) tt3);
                    vTT4.setText(dbt4);
                }
            }
            else if(b3 < b2 && b3 < b4){
                tt2 = b1+b3 - a3;
                dbt3 = Integer.toString((int) tt2);
                vTT2.setText(dbt3);
                if((b1+b3) > b2 || (b1+b3) > b4){
                    if(b2 < b4 || a2 < a4){
                        tt3 = (b1+b3+ b2)- a2;
                        dbt4 = Integer.toString((int) tt3);
                        vTT3.setText(dbt4);
                        // avgWaiting time
                        avgTT = ((b1-a1) + (result-a3) + (result1-a2) + (b1+b2+b3+b4-a4)) / 4;
                        avg = String.format("%,.2f", +avgTT);
                        vAvgTT.setText(avg);
                        tt4 = (b1+b2+b3+ b4)- a4;
                        dbt4 = Integer.toString((int) tt4);
                        vTT4.setText(dbt4);
                    }
                    else {
                        tt4 = (b1+b3+ b2+b4)- a4;
                        dbt4 = Integer.toString((int) tt4);
                        vTT4.setText(dbt4);
                        // avgWaiting time
                        avgTT = ((b1-a1) + (result-a3) + (result1-a2) + (b1+b2+b3+b4-a4)) / 4;
                        avg = String.format("%,.2f", +avgTT);
                        vAvgTT.setText(avg);
                        tt3 = (b1+b3+ b2)- a2;
                        dbt4 = Integer.toString((int) tt3);
                        vTT3.setText(dbt4);
                    }
                }
                else if(b2 < b4 || a2 < a4){
                    tt3 = (b1+b3+ b2)- a2;
                    dbt4 = Integer.toString((int) tt3);
                    vTT3.setText(dbt4);
                    // avgWaiting time
                    avgTT = ((b1-a1) + (result-a3) + (result1-a2) + (b1+b2+b3+b4-a4)) / 4;
                    avg = String.format("%,.2f", +avgTT);
                    vAvgTT.setText(avg);
                    tt4 = (b1+b2+b3+ b4)- a4;
                    dbt4 = Integer.toString((int) tt4);
                    vTT4.setText(dbt4);
                }
                else if (b4 < b2 || a4 < a2){
                    tt4 = (b1+b3+ b2+b4)- a4;
                    dbt4 = Integer.toString((int) tt4);
                    vTT4.setText(dbt4);
                    // avgWaiting time
                    avgTT = ((b1-a1) + (result-a3) + (result1-a2) + (b1+b2+b3+b4-a4)) / 4;
                    avg = String.format("%,.2f", +avgTT);
                    vAvgTT.setText(avg);
                    tt3 = (b1+b3+ b2)- a2;
                    dbt4 = Integer.toString((int) tt3);
                    vTT3.setText(dbt4);
                }
            }
            else if(b4 < b2 && b4 < b3){
                tt2 = b1+b4 - a4;
                dbt3 = Integer.toString((int) tt2);
                vTT2.setText(dbt3);
                if((b1+b4) > b2 || (b1+b4) > b3){
                    if(b2 < b3 || a2 < a3){
                        tt3 = (b1+ b2+b4)- a2;
                        dbt4 = Integer.toString((int) tt4);
                        vTT3.setText(dbt4);
                        // avgWaiting time
                        avgTT = ((b1-a1) + (result-a3) + (result1-a2) + (b1+b2+b3+b4-a4)) / 4;
                        avg = String.format("%,.2f", +avgTT);
                        vAvgTT.setText(avg);
                        tt4 = (b1+b3+ b4+b2)- a3;
                        dbt4 = Integer.toString((int) tt4);
                        vTT4.setText(dbt4);
                    }
                    else{
                        tt3 = (b1+b3+b4)- a3;
                        dbt4 = Integer.toString((int) tt3);
                        vTT3.setText(dbt4);
                        // avgWaiting time
                        avgTT = ((b1-a1) + (result-a3) + (result1-a2) + (b1+b2+b3+b4-a4)) / 4;
                        avg = String.format("%,.2f", +avgTT);
                        vAvgTT.setText(avg);
                        tt4 = (b1+b2+ b3+b4)- a2;
                        dbt4 = Integer.toString((int) tt4);
                        vTT4.setText(dbt4);
                    }
                }
                else if(b2 < b3 || a2 < a3){
                    tt3 = (b1+ b2+b4)- a2;
                    dbt4 = Integer.toString((int) tt4);
                    vTT3.setText(dbt4);
                    // avgWaiting time
                    avgTT = ((b1-a1) + (result-a3) + (result1-a2) + (b1+b2+b3+b4-a4)) / 4;
                    avg = String.format("%,.2f", +avgTT);
                    vAvgTT.setText(avg);
                    tt4 = (b1+b3+ b4+b2)- a3;
                    dbt4 = Integer.toString((int) tt4);
                    vTT4.setText(dbt4);
                }
                else if(b3 < b2 || a3 < a2){
                    tt3 = (b1+b3+b4)- a3;
                    dbt4 = Integer.toString((int) tt3);
                    vTT3.setText(dbt4);
                    // avgWaiting time
                    avgTT = ((b1-a1) + (result-a3) + (result1-a2) + (b1+b2+b3+b4-a4)) / 4;
                    avg = String.format("%,.2f", +avgTT);
                    vAvgTT.setText(avg);
                    tt4 = (b1+b2+ b3+b4)- a2;
                    dbt4 = Integer.toString((int) tt4);
                    vTT4.setText(dbt4);
                }
            }
        }


    }

    private void waitingTime() {
        //burstTIME
        etbt1 = eBT1.getText().toString();
        etbt2 = eBT2.getText().toString();
        etbt3 = eBT3.getText().toString();
        etbt4 = eBT4.getText().toString();
        b1 = Double.parseDouble(etbt1);
        b2 = Double.parseDouble(etbt2);
        b3 = Double.parseDouble(etbt3);
        b4 = Double.parseDouble(etbt4);

        //ARRIVAL TIME
        etAt1 = eAT1.getText().toString();
        etAt2 = eAT2.getText().toString();
        etAt3 = eAT3.getText().toString();
        etAt4 = eAT4.getText().toString();
        a1 = Double.parseDouble(etAt1);
        a2 = Double.parseDouble(etAt2);
        a3 = Double.parseDouble(etAt3);
        a4 = Double.parseDouble(etAt4);


        vWT1.setText("0");

        if (b1 > a2 || b1 > a3 || b1 > a4 ) {
            vWT2.setText(etbt1);
            if(b2 < b3 && b2 < b4){
                pro2.setText("P2");
                result = b1 + b2;
                dbt3 = Integer.toString((int) result);
                vWT3.setText(dbt3);

                if(result > b3 || result > b4){
                    if(b3 < b4 || (b3 == b4 || a3 < a4)){
                        pro3.setText("P3");
                        result1 = result + b3;
                        dbt4 = Integer.toString((int) result1);
                        vWT4.setText(dbt4);
                        // avgWaiting time
                        avgWT = ((b1-a2) + (result-a4) + (result1-a3)) / 4;
                        avg2 = String.format("%,.2f", +avgWT);
                        vAvgWT.setText(avg2);
                        pro4.setText("P4");
                    }
                    else {
                        pro3.setText("P4");
                        result1 = result + b4;
                        dbt4 = Integer.toString((int) result1);
                        vWT4.setText(dbt4);
                        // avgWaiting time
                        avgWT = ((b1-a2) + (result-a3) + (result1-a4)) / 4;
                        avg2 = String.format("%,.2f", +avgWT);
                        vAvgWT.setText(avg2);
                        pro4.setText("P3");

                    }
                }
                else if(b3 < b4 && (b3 == b4 || a3 < a4)){
                    pro3.setText("P3");
                    result1 = result + b3;
                    dbt4 = Integer.toString((int) result1);
                    vWT4.setText(dbt4);
                    // avgWaiting time
                    avgWT = ((b1-a2) + (result-a4) + (result1-a3)) / 4;
                    avg2 = String.format("%,.2f", +avgWT);
                    vAvgWT.setText(avg2);
                    pro4.setText("P4");
                }
                else if (b4 < b3 && (b4 == b3 || a4 < a3)){
                    pro3.setText("P4");
                    result1 = result + b4;
                    dbt4 = Integer.toString((int) result1);
                    vWT4.setText(dbt4);
                    // avgWaiting time
                    avgWT = ((b1-a2) + (result-a3) + (result1-a4)) / 4;
                    avg2 = String.format("%,.2f", +avgWT);
                    vAvgWT.setText(avg2);
                    pro4.setText("P3");
                }
            }
            else if(b3 < b2 && b3 < b4){
                pro2.setText("P3");
                result = b1 + b3;
                dbt3 = Integer.toString((int) result);
                vWT3.setText(dbt3);
                if(result > b2 || result > b4){
                    if(b2 < b4 || a2 < a4){
                        pro3.setText("P2");
                        result1 = result + b2;
                        dbt4 = Integer.toString((int) result1);
                        vWT4.setText(dbt4);
                        // avgWaiting time
                        avgWT = ((b1-a3) + (result-a2) + (result1-a4)) / 4;
                        avg2 = String.format("%,.2f", +avgWT);
                        vAvgWT.setText(avg2);
                        pro4.setText("P4");
                    }
                    else {
                        pro3.setText("P4");
                        result1 = result + b4;
                        dbt4 = Integer.toString((int) result1);
                        vWT4.setText(dbt4);
                        // avgWaiting time
                        avgWT = ((b1-a3) + (result-a4) + (result1-a2)) / 4;
                        avg2 = String.format("%,.2f", +avgWT);
                        vAvgWT.setText(avg2);
                        pro4.setText("P2");
                    }
                }
                else if(b2 < b4 || a2 < a4){
                    pro3.setText("P2");
                    result1 = result + b2;
                    dbt4 = Integer.toString((int) result1);
                    vWT4.setText(dbt4);
                    // avgWaiting time
                    avgWT = ((b1-a3) + (result-a2) + (result1-a4)) / 4;
                    avg2 = String.format("%,.2f", +avgWT);
                    vAvgWT.setText(avg2);
                    pro4.setText("P4");
                }
                else if (b4 < b2 || a4 < a2){
                    pro3.setText("P4");
                    result1 = result + b4;
                    dbt4 = Integer.toString((int) result1);
                    vWT4.setText(dbt4);
                    // avgWaiting time
                    avgWT = ((b1-a3) + (result-a4) + (result1-a2)) / 4;
                    avg2 = String.format("%,.2f", +avgWT);
                    vAvgWT.setText(avg2);
                    pro4.setText("P2");
                }
            }
            else if(b4 < b2 && b4 < b3){
                pro2.setText("P4");
                result = b1 + b4;
                dbt3 = Integer.toString((int) result);
                vWT3.setText(dbt3);
                if(result > b2 || result > b3){
                    if(b2 < b3 || a2 < a3){
                        pro3.setText("P2");
                        result1 = result + b2;
                        dbt4 = Integer.toString((int) result1);
                        vWT4.setText(dbt4);
                        // avgWaiting time
                        avgWT = ((b1-a4) + (result-a2) + (result1-a3)) / 4;
                        avg2 = String.format("%,.2f", +avgWT);
                        vAvgWT.setText(avg2);
                        pro4.setText("P3");
                    }
                    else{
                        pro3.setText("P3");
                        result1 = result + b3;
                        dbt4 = Integer.toString((int) result1);
                        vWT4.setText(dbt4);
                        // avgWaiting time
                        avgWT = ((b1-a4) + (result-a3) + (result1-a2)) / 4;
                        avg2 = String.format("%,.2f", +avgWT);
                        vAvgWT.setText(avg2);
                        pro4.setText("P2");
                    }
                }
                else if(b2 < b3 || a2 < a3){
                    pro3.setText("P2");
                    result1 = result + b2;
                    dbt4 = Integer.toString((int) result1);
                    vWT4.setText(dbt4);
                    // avgWaiting time
                    avgWT = ((b1-a4) + (result-a2) + (result1-a3)) / 4;
                    avg2 = String.format("%,.2f", +avgWT);
                    vAvgWT.setText(avg2);
                    pro4.setText("P3");
                }
                else if(b3 < b2 || a3 < a2){
                    pro3.setText("P3");
                    result1 = result + b3;
                    dbt4 = Integer.toString((int) result1);
                    vWT4.setText(dbt4);
                    // avgWaiting time
                    avgWT = ((b1-a4) + (result-a3) + (result1-a2)) / 4;
                    avg2 = String.format("%,.2f", +avgWT);
                    vAvgWT.setText(avg2);
                    pro4.setText("P2");
                }
            }
        }



    }

}
