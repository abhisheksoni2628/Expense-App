package com.abhishek.em.domain.usecase

import javax.inject.Inject

class GreetUserUseCase @Inject constructor() {
    operator fun invoke(name: String): String {
        return if (name.isNotBlank()) {
            "Hello, $name!"
        } else {
            "Hello!"
        }
    }
}