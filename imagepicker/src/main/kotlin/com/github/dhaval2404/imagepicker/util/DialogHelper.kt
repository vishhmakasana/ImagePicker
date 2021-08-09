package com.github.dhaval2404.imagepicker.util

import android.content.Context
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import com.deishelon.roundedbottomsheet.RoundedBottomSheetDialog
import com.github.dhaval2404.imagepicker.R
import com.github.dhaval2404.imagepicker.constant.ImageProvider
import com.github.dhaval2404.imagepicker.listener.DismissListener
import com.github.dhaval2404.imagepicker.listener.ResultListener
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.security.AccessController.getContext

/**
 * Show Dialog
 *
 * @author Dhaval Patel
 * @version 1.0
 * @since 04 January 2018
 */
internal object DialogHelper {

    /**
     * Show Image Provide Picker Dialog. This will streamline the code to pick/capture image
     *
     */
    fun showChooseAppDialog(
        context: Context, listener: ResultListener<ImageProvider>, dismissListener: DismissListener?
    ) {
        val bottomSheetDialog = RoundedBottomSheetDialog(context)
        val layoutInflater = LayoutInflater.from(context)
        val customView = layoutInflater.inflate(R.layout.dialog_choose_app, null)
        customView.findViewById<View>(R.id.lytCameraPick).setOnClickListener {
            listener.onResult(ImageProvider.CAMERA)
            bottomSheetDialog.dismiss()
        }
        customView.findViewById<View>(R.id.lytGalleryPick).setOnClickListener {
            listener.onResult(ImageProvider.GALLERY)
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.setCancelable(true)
        bottomSheetDialog.setOnCancelListener { listener.onResult(null) }
        bottomSheetDialog.setOnDismissListener { dismissListener?.onDismiss() }
        bottomSheetDialog.setContentView(customView)
        bottomSheetDialog.show()

    }
}
