package app.vazovsky.rick_and_morty.presentation.main

import android.os.Bundle
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.presentation.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}