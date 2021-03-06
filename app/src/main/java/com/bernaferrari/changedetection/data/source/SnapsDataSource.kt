package com.bernaferrari.changedetection.data.source

import android.arch.paging.DataSource
import com.bernaferrari.changedetection.data.MinimalSnap
import com.bernaferrari.changedetection.data.Snap

/**
 * Main entry point for accessing snaps data.
 * Inspired from Architecture Components MVVM sample app
 */
interface SnapsDataSource {

    interface GetSnapsCallback {

        fun onSnapsLoaded(snap: Snap)

        fun onDataNotAvailable()
    }

    interface GetPairCallback {

        fun onSnapsLoaded(pair: Pair<Snap, Snap>)

        fun onDataNotAvailable()
    }

    interface GetMinimalSnapCallback {
        fun onLoaded(intList: List<Int>?)
    }

    fun getMostRecentMinimalSnaps(siteId: String, callback: GetMinimalSnapCallback)

    fun getSnapForPaging(siteId: String): DataSource.Factory<Int, MinimalSnap>

    fun getSnap(snapId: String, callback: GetSnapsCallback)

    fun getSnapPair(originalId: String, newId: String, callback: GetPairCallback)

    fun saveSnap(snap: Snap, callback: GetSnapsCallback)

    fun deleteAllSnapsForSite(siteId: String)

    fun deleteSnap(snapId: String)
}
