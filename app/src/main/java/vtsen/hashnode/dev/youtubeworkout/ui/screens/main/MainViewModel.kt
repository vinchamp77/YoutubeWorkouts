package vtsen.hashnode.dev.youtubeworkout.ui.screens.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
): ViewModel() {

    private val youtubeIds = mutableListOf(
        "rI_6l992GrA", //Mad Fit - 30 MIN FULL BODY HIIT (No Jumping + No Equipment)
        "Urx4gMA2-Kw", //Nobadaddiction - 30 MIN FULL BODY CARDIO HIIT Workout (Intense, No Equipment)
        "ml6cT4AZdqI", //SELF - 30-Minute HIIT Cardio Workout with Warm Up - No Equipment at Home
        "AMVrIBY88d0", //growingannanas - 30 MIN KILLER HIIT Workout - No Equipment, Full Body Cardio, Super Sweaty HIIT Home Workout
        "LZzJBg4tSnI", //JOEY TNG - 30 MIN HIIT for Fat Loss & Strength (No Equipment)
        "DXsYbCuouo4", //Eleni Fit - 30 MIN Full Body Pilates HIIT WORKOUT | Burn 300 Calories | Feel Strong and Balanced | No Repeat
        "xsUSLKyJaAA", //Oliver Sjostrom - 30 Minute Level Up HIIT Cardio Workout (At Home, No Equipment)
        "DzFJzFpTqVo", //Joanna Soh Official - 30-Min Beginner Bodyweight Fat Burning Workout (🔥Burn 300 Calories!)
        "WNUvx5y-1QE", //Juice & Toya - 30 Minute Full Body CARDIO HIIT Workout [ADVANCED + LOW IMPACT]
        "5gW1yR1KoiU", //Healthy Fit with Ty - 30 MIN PYRAMID HIIT with CARDIO KICKBOXING/ NO EQUIPMENT / BURNS CALORIES AND REDUCES STRESS
    ).toList().shuffled()

    private val _youtubeIdsStateFlow = MutableStateFlow(youtubeIds)
    val youtubeIdsStateFlow = _youtubeIdsStateFlow.asStateFlow()

    private val _uiStateFlow = MutableStateFlow<UiState>(UiState.Invalid)
    val uiStateFlow = _uiStateFlow.asStateFlow()

    init {

    }

    fun setUiState(uiState: UiState) {
        _uiStateFlow.value = uiState
    }
}