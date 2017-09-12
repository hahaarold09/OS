package harold.delacerna.com.cpuscheduling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FCFS extends AppCompatActivity {

    EditText eBT1, eBT2, eBT3, eBT4;
    TextView vWT1, vWT2, vWT3, vWT4, vTT1, vTT2, vTT3, vTT4, vAvgWT, vAvgTT;

    Operation op = new Operation();
    double avgWT, avgTT;
    double b1, b2, b3, b4, result, result1, result2;
    String etbt1, etbt2, etbt3, etbt4, dbt2, dbt3, dbt4, avg, avg2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fcfs);
        findViews();
    }

    private void findViews() {
        //burst time
        eBT1 = (EditText) findViewById(R.id.firstBT);
        eBT2 = (EditText) findViewById(R.id.secBT);
        eBT3 = (EditText) findViewById(R.id.thirdBT);
        eBT4 = (EditText) findViewById(R.id.forthBT);
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

        vAvgWT = (TextView) findViewById(R.id.tvAvgWT);
        vAvgTT = (TextView) findViewById(R.id.tvAvgTT);


    }

    public void ComputeFCFS(View view) {
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

        result = op.secTT(b1, b2);
        result1 = op.thirdTT(b1, b2, b3);
        result2 = op.forthTT(b1, b2, b3, b4);

        dbt2 = Integer.toString((int) result);
        dbt3 = Integer.toString((int) result1);
        dbt4 = Integer.toString((int) result2);

        vTT1.setText(etbt1);
        vTT2.setText(dbt2);
        vTT3.setText(dbt3);
        vTT4.setText(dbt4);

        avgTT = (b1 + result + result1 + result2) / 4;
        avg = String.format("%,.2f", +avgTT);
        vAvgTT.setText(avg);
    }

    private void waitingTime() {
        etbt1 = eBT1.getText().toString();
        etbt2 = eBT2.getText().toString();
        etbt3 = eBT3.getText().toString();
        etbt4 = eBT4.getText().toString();

        b1 = Double.parseDouble(etbt1);
        b2 = Double.parseDouble(etbt2);
        b3 = Double.parseDouble(etbt3);
        b4 = Double.parseDouble(etbt4);

        result1 = b1+b2;
        result2 = op.forthAT(b1, b2, b3);

        dbt3 = Integer.toString((int) result1);
        dbt4 = Integer.toString((int) result2);

        vWT1.setText("0");
        vWT2.setText(etbt1);
        vWT3.setText(dbt3);
        vWT4.setText(dbt4);

        avgWT = (b1 + result1 + result2) / 4;
        avg2 = String.format("%,.2f", +avgWT);
        vAvgWT.setText(avg2);
    }


}
