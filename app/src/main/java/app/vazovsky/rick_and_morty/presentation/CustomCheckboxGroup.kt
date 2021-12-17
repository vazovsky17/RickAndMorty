package app.vazovsky.rick_and_morty.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import app.vazovsky.rick_and_morty.R
import app.vazovsky.rick_and_morty.databinding.CustomCheckboxGroupBinding

class CustomCheckboxGroup : LinearLayout {
    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private val binding = CustomCheckboxGroupBinding.inflate(LayoutInflater.from(context), this)

    var title: String = ""
        set(value) {
            field = value
            invalidate()
        }
    val recyclerView: RecyclerView
        get() = binding.recyclerView
    val customViewFlipper: CustomViewFlipper
        get() = binding.customViewFlipper

    private fun init(context: Context, attrs: AttributeSet?) {
        val a = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomCheckboxGroup, 0, 0)
        try {
            orientation = VERTICAL
            title = a.getString(R.styleable.CustomCheckboxGroup_check_title).toString()
            configureViews()
        } finally {
            a.recycle()
        }
    }

    private fun configureViews() = with(binding) {
        textViewTitle.text = title
        buttonExpand.setOnClickListener {
            if (customViewFlipper.visibility == View.GONE) {
                TransitionManager.beginDelayedTransition(customViewFlipper, AutoTransition())
                customViewFlipper.visibility = View.VISIBLE
                imageExpand.setImageResource(R.drawable.ic_expand_less)
            } else {
                TransitionManager.beginDelayedTransition(customViewFlipper, AutoTransition())
                customViewFlipper.visibility = View.GONE
                imageExpand.setImageResource(R.drawable.ic_expand)
            }
        }
    }
}