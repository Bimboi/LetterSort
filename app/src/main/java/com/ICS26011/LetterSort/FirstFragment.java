package com.ICS26011.LetterSort;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView input = view.findViewById(R.id.letter_input);
        final TextView sortText = view.findViewById(R.id.sorted);
        final Button sortButton = view.findViewById(R.id.button_sort);

        view.findViewById(R.id.letter_A).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "A ");
            }
        });

        view.findViewById(R.id.letter_B).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "B ");
            }
        });

        view.findViewById(R.id.letter_C).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "C ");
            }
        });

        view.findViewById(R.id.letter_D).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "D ");
            }
        });

        view.findViewById(R.id.letter_E).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "E ");
            }
        });

        view.findViewById(R.id.letter_F).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "F ");
            }
        });
        view.findViewById(R.id.letter_G).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "G ");
            }
        });
        view.findViewById(R.id.letter_H).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "H ");
            }
        });
        view.findViewById(R.id.letter_I).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "I ");
            }
        });
        view.findViewById(R.id.letter_J).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "J ");
            }
        });
        view.findViewById(R.id.letter_K).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "K ");
            }
        });
        view.findViewById(R.id.letter_L).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "L ");
            }
        });
        view.findViewById(R.id.letter_M).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "M ");
            }
        });
        view.findViewById(R.id.letter_N).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "N ");
            }
        });
        view.findViewById(R.id.letter_O).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "O ");
            }
        });
        view.findViewById(R.id.letter_P).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "P ");
            }
        });
        view.findViewById(R.id.letter_Q).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "Q ");
            }
        });
        view.findViewById(R.id.letter_R).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "R ");
            }
        });
        view.findViewById(R.id.letter_S).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "S ");
            }
        });
        view.findViewById(R.id.letter_T).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "T ");
            }
        });
        view.findViewById(R.id.letter_U).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "U ");
            }
        });
        view.findViewById(R.id.letter_V).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "V ");
            }
        });
        view.findViewById(R.id.letter_W).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "W ");
            }
        });

        view.findViewById(R.id.letter_X).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "X ");
            }
        });

        view.findViewById(R.id.letter_Y).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "Y ");
            }
        });

        view.findViewById(R.id.letter_Z).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addInput(input, "Z ");
            }
        });

        view.findViewById(R.id.button_sort).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sortButton.getText().toString().equals("RESET")) {
                    input.setText("");
                    sortText.setText(requireContext().getString(R.string.sorted_letters_label));
                    sortButton.setText(requireContext().getString(R.string.sort_label));
                }else if (check(input)){
                        sort(input, sortText, sortButton);
                }else{
                    Toast.makeText(getContext(), "Please input 5 letters", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addInput(TextView rawInput, String letter) {
        if (rawInput.getText().toString().replace(" ", "").length() <= 4){
            rawInput.setText(rawInput.getText() + letter);
        }else{
            Toast.makeText(getContext(), "Cannot exceed 5 letters", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean check(TextView rawInput){
        if (rawInput.getText().toString().replace(" ", "").length() == 5){
            return true;
        }else{
            return false;
        }
    }

    private void sort(TextView rawInput, TextView sortText, Button sortButton){
        char[] charArray = rawInput.getText().toString().replace(" ", "").toCharArray();
        Arrays.sort(charArray);
        sortText.setText(new String(charArray).replace("", " "));
        sortButton.setText("RESET");
    }
}
