import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import InputBlock from './InputBlock'
import NextButton from './NextButton'
import { router } from 'expo-router'

const Parametrs = () => {
  return (
    <>
      <View>
        <Text style={styles.oneTitle}>Дата рождения:</Text>
        <View style={styles.flineInputs}>
            <View style={styles.flineInputsItem}><InputBlock placeHolderText='ДД'/></View>
            <View style={styles.flineInputsItem}><InputBlock placeHolderText='ММ'/></View>
            <View style={styles.flineInputsItem}><InputBlock placeHolderText='ГГГГ'/></View>
        </View>
      </View>

      <View style={styles.flineInputs}>
        <View style={styles.flineInputsItem}>
            <Text style={styles.manyTitles}>Рост:</Text>
            <InputBlock placeHolderText='СМ'/>
        </View>
        <View style={styles.flineInputsItem}>
            <Text style={styles.manyTitles}>Пол:</Text>
            <InputBlock placeHolderText='Ж/М'/>
        </View>
        <View style={styles.flineInputsItem}>
            <Text style={styles.manyTitles}>Вес:</Text>
            <InputBlock placeHolderText='КГ'/>
        </View>
      </View>

      <View>
        <Text style={styles.oneTitle}>Обхват:</Text>
        <View style={styles.flineInputs}>
            <View style={styles.flineInputsItem}><InputBlock placeHolderText='Грудь'/></View>
            <View style={styles.flineInputsItem}><InputBlock placeHolderText='Талия'/></View>
            <View style={styles.flineInputsItem}><InputBlock placeHolderText='Бедра'/></View>
        </View>

        
      </View>
      <NextButton text='Продолжить' handlePress={()=>{router.push('../(app)/main')}}/>
    </>
  )
}

export default Parametrs

const styles = StyleSheet.create({
    flineInputs: {
        flexDirection: 'row', 
        gap: 13
    },
    flineInputsItem: {
        flexGrow: 1,
    },
    oneTitle:{
        textAlign: 'center',
        marginBottom: 13,
        color: '#4CAC44',
        fontSize: 16,
        lineHeight: 19,
        marginTop: 5
    },
    manyTitles:{
        color: '#4CAC44',
        marginBottom: 13,
        fontSize: 16,
        lineHeight: 19,
        marginTop: 5
    }
})