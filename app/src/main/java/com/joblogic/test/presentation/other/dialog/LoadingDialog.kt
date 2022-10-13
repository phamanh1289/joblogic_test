package com.joblogic.test.presentation.other.dialog

import com.joblogic.test.BR
import com.joblogic.test.R
import com.joblogic.test.databinding.DialogLoadingBinding
import com.joblogic.test.presentation.core.base.BaseDialogFragment

class LoadingDialog :
    BaseDialogFragment<DialogLoadingBinding>() {

    override fun requestLayout() = R.layout.dialog_loading

    override fun requestLayoutXml() = BR.dialogLoading

    override fun setCancelDialog() = false

}