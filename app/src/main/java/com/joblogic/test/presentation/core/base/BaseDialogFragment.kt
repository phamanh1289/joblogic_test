package com.joblogic.test.presentation.core.base

import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

abstract class BaseDialogFragment<VDB : ViewDataBinding> : DialogFragment() {

    lateinit var binding: VDB

    private var isStatusShow = false

    @LayoutRes
    protected abstract fun requestLayout(): Int

    protected abstract fun requestLayoutXml(): Int

    protected abstract fun setCancelDialog(): Boolean?

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, requestLayout(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.run {
            setCanceledOnTouchOutside(setCancelDialog() ?: false)
            isCancelable = setCancelDialog() ?: false
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        binding.apply {
            lifecycleOwner = this@BaseDialogFragment
            setVariable(requestLayoutXml(), this@BaseDialogFragment)
            executePendingBindings()
        }
    }

    override fun show(manager: FragmentManager, tag: String?) {
        if (!isStatusShow && !isAdded) {
            isStatusShow = true
            super.show(manager, tag)
        }
    }

    override fun dismiss() {
        if (isStatusShow) {
            isStatusShow = false
            super.dismiss()
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        if (isStatusShow) {
            isStatusShow = false
            super.onDismiss(dialog)
        }
    }

}