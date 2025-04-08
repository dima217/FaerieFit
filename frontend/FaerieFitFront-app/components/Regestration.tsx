import { StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'
import InputBlock from './InputBlock'
import NextButton from './NextButton'
import { Link, router } from 'expo-router'

const Regestration = () => {

  const [passwordStrength, setPasswordStrength] = useState('')
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [errorMessage, setErrorMessage] = useState('');

  const handlePasswordChange = (password:string) => {
    setPassword(password)
    // Проверка на минимальную длину 8 символов
    if (!/^.{8,30}$/.test(password)) {
      setPasswordStrength('Пароль должен содержать 8-30 символов');
      return;
    }
  
    // Проверка на наличие только латинских символов
    if (!/^(?=.*\d)/.test(password)) {
      setPasswordStrength('Пароль должен содержать цифру');
      return;
    }
  
    // Проверка на наличие хотя бы одной строчной буквы
    if (!/(?=.*[a-z])/.test(password)) {
      setPasswordStrength('Пароль должен содержать строчную букву');
      return;
    }
    
    // Проверка на наличие хотя бы одной заглавной буквы
    if (!/(?=.*[A-Z])/.test(password)) {
      setPasswordStrength('Пароль должен содержать заглавную букву');
      return;
    }

    // Проверка на наличие хотя бы одного специального символа
    if (!/(?=.*\W)/.test(password)) {
      setPasswordStrength('Пароль должен содержать специальный символ');
      return;
    }
  
    // Если все условия выполнены, сбросим предупреждение
    setPasswordStrength('Пароль достаточно сильный');
  };
  

  const handleNextPress = () => {
    if (password === confirmPassword) {
      // Если пароли совпадают, сбросить сообщение об ошибке и выполнить переход
      setErrorMessage('');
      router.push('/params');
    } else {
      // Если пароли не совпадают, установить сообщение об ошибке
      setErrorMessage('Пароли не совпадают');
    }
  };

  return (
    <>
        <InputBlock placeHolderText='Имя'/>
        <InputBlock placeHolderText='Email'/>
        <InputBlock placeHolderText='Пароль' onChangeText={handlePasswordChange} isPassword={true}/>
        {passwordStrength.length == 0 ? null : <Text style={styles.CheckPassText}>{passwordStrength}</Text>}
        <InputBlock placeHolderText='Подтвердить пароль' onChangeText={setConfirmPassword} isPassword={true}/>
        {errorMessage.length > 0 ? <Text style={styles.CheckPassText}>{errorMessage}</Text> : null}
        <NextButton text='Продолжить' handlePress={handleNextPress}/>
        <Text style={styles.flineText}>Уже есть аккаунт? <Link href='/sign-in' style={styles.flineZareg}>Войти</Link></Text>
    </>

  )
}

export default Regestration

const styles = StyleSheet.create({
    flineText:{
        marginTop: 13,
        marginBottom: 8,
        textAlign: 'center',
        color: '#565956'
    },
    flineZareg:{
        color: '#4CAC44',
        textDecorationLine: 'underline', 
    },
    CheckPassText:{
      fontSize: 13,
      lineHeight: 15.6,
      marginBottom: 13,
      marginLeft: 5,
      color: '#565956'
    }
})