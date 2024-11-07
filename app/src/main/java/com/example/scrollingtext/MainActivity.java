package com.example.scrollingtext;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.scrollingtext.R;

public class MainActivity extends AppCompatActivity {

    private EditText commentTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Configuración de ajustes para bordes
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Referencias al botón y TextView de comentarios
        Button commentButton = findViewById(R.id.comment_button);
        commentTextView = findViewById(R.id.comment_text);

        // Configura el evento de clic en el botón
        commentButton.setOnClickListener(view -> {
            // Habilita y muestra el TextView si está inhabilitado
            if (!commentTextView.isEnabled()) {
                commentTextView.setEnabled(true);
                commentTextView.setVisibility(View.VISIBLE);
                commentTextView.requestFocus();
            }
        });
    }
}
