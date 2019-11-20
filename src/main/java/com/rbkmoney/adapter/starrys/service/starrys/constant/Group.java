package com.rbkmoney.adapter.starrys.service.starrys.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Обязательное строковое поле Group определяет в какой группе должно находиться устройство для отправки запроса.
 * Значение по умолчанию: GROUP0.
 * Имя группы на устройстве можно изменить посредством редактирования таблицы No250 (см. табл. 37).
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Group {
    public static final String DEFAULT = "GROUP0";
}
