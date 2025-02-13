import { StatusBar, StyleSheet, Text, View } from 'react-native'
import React, { Children } from 'react'
import { Stack } from 'expo-router'
import style from '@/constants/style'
import { SafeAreaView } from 'react-native-safe-area-context'


export interface MTProps{
    children: React.ReactNode
}

const MainTemplate = ({children}:MTProps) => {
  return (
    <SafeAreaView style={styles.main}>
        <StatusBar barStyle="light-content" backgroundColor="#4CAC44"/>
        <View style={styles.header}>
            <Text style={styles.text}>Главная</Text>
            {/* <Image/> */}
        </View>
        {children}
    </SafeAreaView>
  )
}

export default MainTemplate

const styles = StyleSheet.create({
    main:{
        flex:1,
        backgroundColor:"#474747",
    },

    сhildren:{
        // backgroundColor:"#474747", // Фон статус-бара (только на Android)
        // flex: 1,
    },
    header:{
        backgroundColor:'#4CAC44'
    },
    text: {
        fontSize: 20,
        color: '#B0E4AC',
        textAlign:'center'
    },
    home:{
        width:36,
        height:36
    }
})