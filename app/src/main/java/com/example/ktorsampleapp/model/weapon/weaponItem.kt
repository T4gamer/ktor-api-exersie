package com.example.ktorsampleapp.model.weapon

data class weaponItem(
    val attack_type: String,
    val bonus: Bonus,
    val damage: Damage,
    val damage_reduction: DamageReduction,
    val durability: Int,
    val name: String,
    val requirements: Requirements,
    val weapon_type: String,
    val weight: Double
)