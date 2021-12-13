package app.vazovsky.rick_and_morty.presentation

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecorator : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = 12
        outRect.bottom = 12
        outRect.left = 12
        outRect.right = 12
    }
}