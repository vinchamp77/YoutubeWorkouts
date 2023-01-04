package vtsen.hashnode.dev.youtubeworkout.ui.screens.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
): ViewModel() {

    // no equipment/weight workouts
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
        "hAmY9LeE1r4", //Coffee林芊妤 - 30min Intense Full Body Workout - Instant Body Toning | Total Body Muscle
        "W4eKVKwf3rQ", //emi wong - 30 min Full Body Fat Burn HIIT (NO JUMPING) - Ab, Core, Arm, Back, Leg, Thigh & Cardio
        "ci7yepZHwm0", //Hasfit - 30 Min Beginner HIIT Workout for Fat Loss at Home - Standing No Jumping Low Impact Cardio Workout
        "96FVffJltL8", //Heather Robertson - 30MIN Intense HIIT Cardio (No Equipment)
        "c01hlF_EdRk", //Pamela Reif - 30 MIN UPPER BODY & ABS - Let's train together / No Equipment
        "PXnUli_4dxU", //周六野 Zoey - 30分钟全程站立有氧燃脂操｜无跳跃无深蹲膝友好,小空间无工具
        "ZMO_XC9w7Lw", //Les Mills - WORK OUT #LIKENINA | 30-minute LES MILLS GRIT Cardio Workout
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