package com.techlads.swvl.utils

import com.techlads.swvl.data.entities.FlickerResponse


/**
 *
 * Kotlin
 *
 * @author Umair Khalid (umair.khalid786@outlook.com)
 * @package com.techlads.swvl.utils
 */


class Utils {

    companion object {
        fun replaceAll(photo: FlickerResponse.Photos.Photo) : String{
            //"http://farm{farm}.static.flickr.com/{server}/{id}_{secret}.jpg"
            var url = IMAGE_URL
            url = url.replace("{farm}" , photo.farm)
            url = url.replace("{server}" , photo.server)
            url = url.replace("{id}" , photo.id)
            url = url.replace("{secret}" , photo.secret)
            return url
        }
    }
}