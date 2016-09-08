package android.com.demosignature;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.kyanogen.signatureview.SignatureView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private SignatureView signature_view = null;
    private Button btn_clear = null;
    private Button btn_save = null;
    private ImageView img_signature = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    /**
     * initialize view elements.
     */
    private void init(){
        signature_view = (SignatureView) findViewById(R.id.signature_view);
        img_signature = (ImageView) findViewById(R.id.img_signature);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_save = (Button) findViewById(R.id.btn_save);

        btn_clear.setOnClickListener(this);
        btn_save.setOnClickListener(this);
    }


    /**
     * clears signature
     */
    private void clearSignature(){
        signature_view.clearCanvas();
        img_signature.setImageBitmap(null);
    }

    /**
     * saves signature
     */
    private void saveSignature(){
        Bitmap bmpSignature = signature_view.getSignatureBitmap();

        img_signature.setImageBitmap(bmpSignature);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_clear:
                clearSignature();
                break;

            case R.id.btn_save:
                saveSignature();
                break;

        }
    }
}

