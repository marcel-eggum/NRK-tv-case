package no.nrk.tv.common

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import no.nrk.tv.R

object Util {

    fun openWebPage(context: Context, url: String): Result<Boolean> {
        return runCatching {
            val webpage: Uri = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, webpage)

            if (intent.resolveActivity(context.packageManager) != null) {
                context.startActivity(intent)
                return Result.success(true)
            } else {
                throw Throwable("Unable to resolve browser activity")
            }
        }.onFailure {
            Log.e(TAG, it.message, it)
            return Result.failure(it)
        }
    }

    fun toast(context: Context, message: String) {
        Toast.makeText(
            context,
            message,
            Toast.LENGTH_SHORT
        ).show()
    }
}