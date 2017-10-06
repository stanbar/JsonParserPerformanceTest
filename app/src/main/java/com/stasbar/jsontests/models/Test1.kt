package com.stasbar.jsontests.models

import com.google.gson.annotations.SerializedName

/**
 * Created by stasbar on 06.10.2017.
 */

class Test1 {

    @SerializedName("new")
    lateinit var listNew: Array<ItemOld>

    lateinit var IdKat: String

    lateinit var data_gen: String

    lateinit var polaczenie: String

    @SerializedName("download")
    lateinit var listDownload: Array<ItemOld>

    @SerializedName("like")
    lateinit var listLike: Array<ItemOld>
}
