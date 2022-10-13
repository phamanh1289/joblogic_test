package com.joblogic.test.presentation.helper.extension

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.joblogic.test.presentation.core.base.BaseActivity
import com.joblogic.test.presentation.core.base.BaseFragment

private fun Fragment.validateBaseActivity(action: () -> Unit) {
    if (activity is BaseActivity<*, *>)
        action()
}

private fun Fragment.getCurrentActivity() = (activity as BaseActivity<*, *>)

fun Fragment.showLoading() = validateBaseActivity { getCurrentActivity().showLoading() }

fun Fragment.hideLoading() = validateBaseActivity { getCurrentActivity().hideLoading() }

fun Fragment.showToast(content: String) =
    validateBaseActivity { getCurrentActivity().showToast(content) }

fun Fragment.showDialogs(dialog: DialogFragment) =
    validateBaseActivity { getCurrentActivity().showDialogs(dialog) }

fun Fragment.addFragment(
    fragment: BaseFragment<*, *>,
    view: Int? = null,
    isAddToBackStack: Boolean = true
) {
    validateBaseActivity { getCurrentActivity().addFragment(fragment, view, isAddToBackStack) }
}
