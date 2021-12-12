package app.vazovsky.sampledagger.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.vazovsky.sampledagger.R
import app.vazovsky.sampledagger.presentation.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}