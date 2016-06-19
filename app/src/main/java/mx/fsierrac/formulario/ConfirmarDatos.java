package mx.fsierrac.formulario;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    TextView tvNombre;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDesc;
    TextView tvFecha;
    String nombre, telefono, email, descripcion, fecha;
    Button editar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        editar = (Button) findViewById(R.id.btnEditar);
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTel);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDesc= (TextView) findViewById(R.id.tvDesc);
        tvFecha = (TextView) findViewById(R.id.tvFechaN);


        Bundle extras = getIntent().getExtras();

        if (extras!=null){

            tvNombre.setText(extras.getString("NOMBRE"));
            tvFecha.setText(extras.getString("FECHA"));
            tvTelefono.setText(extras.getString("TELEFONO"));
            tvEmail.setText(extras.getString("EMAIL"));
            tvDesc.setText(extras.getString("DESC"));
        }

        nombre = tvNombre.getText().toString();
        telefono = tvTelefono.getText().toString();
        email = tvEmail.getText().toString();
        descripcion = tvDesc.getText().toString();
        fecha = tvFecha.getText().toString();

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ConfirmarDatos.this, MainActivity.class);
                i.putExtra("NOM", nombre);
                i.putExtra("TEL", telefono);
                i.putExtra("EM", email);
                i.putExtra("FE", fecha);
                i.putExtra("DES", descripcion);
                setResult(RESULT_OK, i);
                finish();
            }
        });

    }
}
