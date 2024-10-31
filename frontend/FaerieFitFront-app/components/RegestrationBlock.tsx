import { StyleSheet, Text, View } from 'react-native'
import React from 'react'

const RegestrationBlock = () => {
  return (
    <View style={styles.mainView}>
        <Text style={styles.title}>Добро пожаловать!</Text>
        <View></View>
    </View>
  )
}

export default RegestrationBlock

const styles = StyleSheet.create({
    mainView:{
        backgroundColor: '#4CAC44',
        borderRadius: 20,
        width: '100%',
        alignItems: 'center'
    },
    title:{
        fontSize: 24,
        color: '#565956',
        marginTop: 30,
        marginBottom: 20
    }
})