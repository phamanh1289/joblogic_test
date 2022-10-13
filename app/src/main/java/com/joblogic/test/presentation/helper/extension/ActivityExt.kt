package com.joblogic.test.presentation.helper.extension

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.joblogic.test.R
import com.joblogic.test.presentation.core.base.BaseFragment
import com.joblogic.test.presentation.feature.home.MainActivity

fun AppCompatActivity.addFragment(
    fragment: BaseFragment<*, *>,
    view: Int? = null,
    isAddToBackStack: Boolean = true
) {
    supportFragmentManager.hideCurrentFragment(view) {
        val simpleName = fragment::class.java.simpleName
        add(view ?: R.id.actMain_frame, fragment, simpleName)
        if (isAddToBackStack) {
            addToBackStack(simpleName)
            if (this@addFragment is MainActivity)
                this@addFragment.addCountBack()
        }
    }
}

private inline fun FragmentManager.hideCurrentFragment(
    view: Int?,
    action: FragmentTransaction.() -> Unit
) {
    beginTransaction().apply {
        setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        findFragmentById(view ?: R.id.actMain_frame)?.let { hide(it) }
        action()
    }.commitAllowingStateLoss()
}

fun AppCompatActivity.showToast(content: String) =
    Toast.makeText(this, content, Toast.LENGTH_SHORT).show()

fun AppCompatActivity.showDialogs(dialog: DialogFragment) = supportFragmentManager.let {
    if (!it.isStateSaved)
        dialog.show(it, dialog::class.java.simpleName)
}
