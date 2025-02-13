import { StyleSheet, Text, TouchableOpacity, View } from 'react-native';
import React, { useState } from 'react';
import NextButton from './NextButton';
import { Link, router } from 'expo-router';
import Checkbox from 'expo-checkbox';

const Welcome = () => {
  const [isChecked, setChecked] = useState(false);

  const handleNextPress = () => {
    if (isChecked) {
      router.push('/(auth)/sign-in');
    } else {
      alert("Пожалуйста, ознакомьтесь с политикой конфиденциальности, чтобы продолжить.");
    }
  };

  return (
    <>
      <Text style={styles.text}>
        Мы стремимся к полной конфиденциальности наших пользователей!{'\n'}Чтобы продолжить стремиться к желаемому состоянию здоровья и телосложения, нам необходимо согласие на обработку ваших персональных данных.
      </Text>
      <View style={styles.checkboxContainer}>
        <View style={[styles.checkboxWrapper, isChecked && styles.checkedBorder]}>
          <Checkbox 
            style={styles.checkbox}
            value={isChecked}
            onValueChange={setChecked}
            color={isChecked ? '#93d38d' : undefined}
          />
        </View>
        <Text style={styles.checkBoxText}>
          Ознакомлен(а) с <Link style={styles.privacyText} href={'/params'}>политикой конфиденциальности</Link>
        </Text>
      </View>
      <NextButton text='Продолжить' handlePress={handleNextPress} />
    </>
  );
}

export default Welcome;

const styles = StyleSheet.create({
  text: {
    textAlign: 'center',
    color: '#565956',
    fontSize: 18,
    lineHeight: 22,
  },
  checkboxContainer: {
    justifyContent: 'center',
    alignItems: 'center',
    flexDirection: 'row',
    marginBottom: 20,
    marginTop: 5,
    gap: 5,
  },
  checkboxWrapper: {
    padding: -2,
    borderRadius: 1,
    borderWidth: 2,
    borderColor: '#93d38d'
  },
  checkedBorder: {
    borderColor: '#657786', // Цвет границы, когда чекбокс активен
  },
  checkbox: {
    height: 12,
    width: 12,
  },
  checkBoxText: {
    color: '#474747',
    fontSize: 12,
  },
  privacyText: {
    color: '#4CAC44',
  },
});
