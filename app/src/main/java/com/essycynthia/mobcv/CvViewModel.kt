package com.essycynthia.mobcv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CvViewModel : ViewModel() {
    private var _fullNames: MutableLiveData<String> = MutableLiveData("Esther Cynthia")
    private var _slackUserName: MutableLiveData<String> = MutableLiveData("Essy Cynthia")
    private var _githubHandle: MutableLiveData<String> = MutableLiveData("essy16")
    private var _personalBio: MutableLiveData<String> = MutableLiveData("\n" +

            "I am a passionate and dedicated individual with a deep love for coding. My commitment to hard work and continuous learning drives me to explore and excel in the world of software development. With a keen eye for detail and a creative approach to problem-solving, I'm always eager to take on new challenges and contribute to innovative solutions.")
    val fullNames : LiveData<String>  = _fullNames
    val slackUserName : LiveData<String>  = _slackUserName
    val githubHandle : LiveData<String>  = _githubHandle
    val personalBio : LiveData<String>  = _personalBio

    fun updateName(newName: String) {
        _fullNames.value = newName
    }

    fun updateSlackUserName(newSlackUserName: String) {
        _slackUserName.value = newSlackUserName
    }

    fun updateGithubHandle(newGithubHandle: String) {
        _githubHandle.value = newGithubHandle
    }

    fun updatePersonalBio(newBio: String) {
        _personalBio.value = newBio
    }
}