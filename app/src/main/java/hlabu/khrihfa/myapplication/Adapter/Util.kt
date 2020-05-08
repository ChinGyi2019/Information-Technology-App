package hlabu.khrihfa.myapplication.Adapter


import android.app.Fragment
import android.support.annotation.IdRes

import android.support.v7.app.AppCompatActivity


fun AppCompatActivity.replaceFragmenty(fragment: Fragment,
                                       allowStateLoss: Boolean = false,
                                       @IdRes containerViewId: Int) {
    var ft = fragmentManager!!
        .beginTransaction()
        .replace(containerViewId, fragment)
    if (!supportFragmentManager.isStateSaved) {
        ft.commit()
    } else if (allowStateLoss) {
        ft.commitAllowingStateLoss()
    }
}