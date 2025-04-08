import React, { useState } from 'react';
import { View, TextInput, Text, StyleSheet } from 'react-native';

interface InputFieldProps{
    placeHolderText: string,
    onChangeText?: (text: string) => void;
    isPassword?: boolean
}

const InputField = ({placeHolderText, onChangeText, isPassword}: InputFieldProps) => {
  const [text, setText] = useState(''); // Состояние для хранения введенного текста

  return (
    <TextInput
        style={styles.input}        // Стили для поля ввода             // Значение поля ввода
        onChangeText={onChangeText}      // Обработчик изменений текста
        placeholder={placeHolderText}
        placeholderTextColor={'#56595680'} // Подсказка, если поле пустое
        secureTextEntry={isPassword}
    />
  );
};

const styles = StyleSheet.create({
  input: {
    borderRadius: 10,
    borderWidth: 1,                // Устанавливаем ширину границы
    borderColor: 'rgb(86, 89, 86)', // Устанавливаем цвет границы
    borderStyle: 'solid', 
    height: 42,
    paddingHorizontal: 20,
    color: '#565956',
    fontSize: 18,
    lineHeight: 22,
    marginBottom: 13,
    backgroundColor: '#B0E4AC',
  },
});

export default InputField;
