package mx.fsierrac.formulario;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;


public class MainActivity extends AppCompatActivity {

    TextInputEditText Nombre, Telefono, Email, Descripcion;
    String nombre, telefono, email, descripcion, fecha;
    DatePicker fechaNac;
    Button Siguiente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nombre = (TextInputEditText) findViewById(R.id.edtNombre);
        Telefono = (TextInputEditText) findViewById(R.id.edtTelefono);
        Email = (TextInputEditText) findViewById(R.id.edtEmail);
        Descripcion = (TextInputEditText) findViewById(R.id.edtDescripcion);
        fechaNac = (DatePicker) findViewById(R.id.dpFechaN);
        Siguiente = (Button) findViewById(R.id.btnSiguiente);

        Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nombre = Nombre.getText().toString();
                telefono = Telefono.getText().toString();
                email = Email.getText().toString();
                descripcion = Descripcion.getText().toString();
                fecha = fechaNac.getDayOfMonth() + "/" + (fechaNac.getMonth() + 1) + "/" + fechaNac.getYear();

                Intent i = new Intent(MainActivity.this, ConfirmarDatos.class);

                i.putExtra("NOMBRE", nombre);
                i.putExtra("TELEFONO", telefono);
                i.putExtra("EMAIL", email);
                i.putExtra("FECHA", fecha);
                i.putExtra("DESC", descripcion);
                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

                Nombre.setText(data.getStringExtra("NOM"));
                Telefono.setText(data.getStringExtra("TEL"));
                Email.setText(data.getStringExtra("EM"));
                Descripcion.setText(data.getStringExtra("DES"));
            }
        }

    }
}

