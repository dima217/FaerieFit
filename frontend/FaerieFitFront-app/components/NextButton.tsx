import { StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import React from 'react'

interface NextButtonProps{
    text: string,
    handlePress: ()=>void
}

const NextButton = ({text, handlePress}: NextButtonProps) => {
  return (
    <TouchableOpacity 
        style={styles.main}
        onPress={handlePress}
    >
        <Text style={styles.text}>{text}</Text>
    </TouchableOpacity>
  )
}

export default NextButton

const styles = StyleSheet.create({
    text:{
        fontSize: 18,
        lineHeight: 22,
        color: '#565956'
    },
    main:{
        alignItems: 'center',
        justifyContent: 'center',
        width: '100%',
        borderWidth: 1,                  // Аналог border
        borderColor: 'rgb(86, 89, 86)',  // Аналог border-color
        borderRadius: 10,                // Аналог border-radius
        height: 42
    }
})