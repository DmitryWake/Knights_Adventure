package com.wake.knightsadventure.data.controller.fight

import com.wake.knightsadventure.data.controller.ability.AbilityControllerInterface
import com.wake.knightsadventure.data.model.ability.BaseAbilityModel
import com.wake.knightsadventure.data.model.FightModel
import com.wake.knightsadventure.data.model.ability.AbilityControllerModel
import java.util.Random

class FightController(
    private val data: FightModel,
    private val abilityController: AbilityControllerInterface
) : FightControllerInterface {

    private val random = Random(System.currentTimeMillis())

    var onFightNextListener: OnFightNextListener? = null
    var onFinishListener: OnFinishListener? = null

    override fun onStart() {
        // START
    }

    override fun onNext(abilityList: List<BaseAbilityModel>) {
        val enemyAbilities = List(MAX_FIGHT_ABILITIES) {
            data.playersData.second.abilityList.let { list ->
                list[random.nextInt() % list.size]
            }
        }

        repeat(MAX_FIGHT_ABILITIES) { index ->
            val playerAbility = abilityList.getOrNull(index)
            val enemyAbility = enemyAbilities.getOrNull(index)

            var abilityData = AbilityControllerModel(
                playerData = Pair(data.playersData.first, playerAbility),
                enemyData = Pair(data.playersData.second, enemyAbility)
            )

            abilityData = abilityController.process(abilityData)

            data.playersData = Pair(abilityData.playerData.first, abilityData.enemyData.first)
        }

        onFightNextListener?.onNext(data)

        if (data.playersData.first.healthPoints < 0) {
            onFinishListener?.onFinish(false)
        } else if (data.playersData.second.healthPoints < 0) {
            onFinishListener?.onFinish(true)
        }
    }

    override fun onStop() {
        // STOP
    }

    fun interface OnFightNextListener {
        fun onNext(model: FightModel)
    }

    fun interface OnFinishListener {
        fun onFinish(win: Boolean)
    }

    companion object {
        private const val MAX_FIGHT_ABILITIES = 3
    }
}