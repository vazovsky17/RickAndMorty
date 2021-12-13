package app.vazovsky.rick_and_morty.data.model

sealed class StateDownloadProgress {
    class Progress(var progress: Int) : StateDownloadProgress()
    class Error(var error: String) : StateDownloadProgress()
}