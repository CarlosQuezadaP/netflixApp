package com.instaleap.netflixapp

import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.instaleap.core.Resource

fun Fragment.handleApiError(
    failure: Resource.Failure,
    bottomNavigationView: BottomNavigationView
) {
    val result = when {
        failure.isNetworkError ->
            "Please check your internet connection"

        failure.errorCode == 404 -> {
            "Not content Found, ${failure.errorCode}"
        }
        else -> {
            failure.errorBody ?: "Error ${failure.errorCode}"
        }
    }

    requireView().snackbar(result, bottomNavigationView)
}


fun View.snackbar(
    message: String,
    bottomNavigationView: BottomNavigationView
) {
    Snackbar.make(this, message, Snackbar.LENGTH_INDEFINITE).apply {
        anchorView = bottomNavigationView
        setAction("ok") {
            this.dismiss()
        }
        show()
    }

}
