package com.rbkmoney.adapter.starrys.service.starrys.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Обязательное поле Device может принимать несколько видом значений (тип   строка):
 * 1. Серийный (заводской) номер устройства (строка 20 символов),
 * 2. "auto".
 * <p>
 * Серийный (заводской) номер устройства используется для отправки команды на конкретное устройство
 * и может использоваться как с простыми командами, так и с пакетными.
 * Значение "auto" может быть использовано только с пакетными командами. Для выбора
 * доступны только устройства, находящиеся в фискальном режиме (см. табл. 6).
 * <p>
 * При выборе устройства стратегии применяются в следующем порядке, до первого срабатывания:
 * 1. Duration
 * 2. QueueLen
 * 3. Durations
 * 4. QueueLens
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Device {

    public static final String AUTO = "auto";

}
