package com.juliansparber.SpeakerButton;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

public class ButtonReceiver extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent.getAction().equals("android.intent.action.VOICE_COMMAND")) {
            AudioManager audioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
            KeyEvent key_down = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE);
            audioManager.dispatchMediaKeyEvent(key_down);
            KeyEvent key_up = new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE);
            audioManager.dispatchMediaKeyEvent(key_up);
            finish();
        } else {
            setContentView(R.layout.activity_main);
            TextView text = this.findViewById(R.id.textbox);
            text.setText(intent.getAction());
        }
    }
}
