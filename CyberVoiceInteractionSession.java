package com.cyberai.app;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/** Minimal system assistant surface. Tapping opens the full Cyber AI experience. */
public class CyberVoiceInteractionSession extends VoiceInteractionSession {
    public CyberVoiceInteractionSession(CyberVoiceInteractionSessionService service) {
        super(service);
    }

    @Override public View onCreateContentView() {
        LinearLayout root = new LinearLayout(getContext());
        root.setOrientation(LinearLayout.VERTICAL);
        root.setGravity(Gravity.CENTER);
        root.setPadding(28, 28, 28, 28);
        GradientDrawable bg = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{Color.rgb(7,17,31), Color.rgb(12,43,31)});
        bg.setCornerRadius(42f);
        root.setBackground(bg);

        TextView title = new TextView(getContext());
        title.setText("Cyber AI");
        title.setTextColor(Color.WHITE);
        title.setTextSize(27);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);
        root.addView(title, new LinearLayout.LayoutParams(-1, -2));

        TextView subtitle = new TextView(getContext());
        subtitle.setText("Your phone assistant is ready.");
        subtitle.setTextColor(Color.LTGRAY);
        subtitle.setTextSize(15);
        subtitle.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams sp = new LinearLayout.LayoutParams(-1, -2);
        sp.topMargin = 12;
        root.addView(subtitle, sp);

        Button open = new Button(getContext());
        open.setText("Open Cyber AI");
        open.setOnClickListener(v -> openCyberAI());
        LinearLayout.LayoutParams bp = new LinearLayout.LayoutParams(-1, -2);
        bp.topMargin = 22;
        root.addView(open, bp);
        return root;
    }

    private void openCyberAI() {
        Intent i = new Intent(getContext(), MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.putExtra("FROM_SYSTEM_ASSISTANT", true);
        getContext().startActivity(i);
        finish();
    }
}
