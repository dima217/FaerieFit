import { StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import React from 'react'
import InputBlock from './InputBlock'
import NextButton from './NextButton'
import { Link, router } from 'expo-router'

const Enter = () => {
    return (
        <>
            <InputBlock
                placeHolderText='Email'
            />
            <InputBlock
                placeHolderText='Пароль'
                isPassword={true}
            />
            <NextButton text='Продолжить' handlePress={()=>{router.push('/params')}}/>
            <Text style={styles.flineText}>Еще нет аккаунта? <Link href="/sign-up" style={styles.flineZareg}>Зарегистрируйся</Link></Text>
            <TouchableOpacity style={styles.sline}><Text style={styles.slineText}>Забыли пароль</Text></TouchableOpacity>
        </>
    )
}

export default Enter

const styles = StyleSheet.create({
    flineText:{
        marginTop: 13,
        textAlign: 'center',
        color: '#565956'
    },
    flineZareg:{
        color: '#4CAC44',
        textDecorationLine: 'underline', 
    },
    sline:{
        alignItems: 'center',
        
    },
    slineText:{
        color: '#4CAC44'
    }
})