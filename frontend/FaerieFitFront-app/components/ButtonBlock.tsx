import { StatusBar, StyleSheet, Text, View, Image, TouchableOpacity, ImageSourcePropType } from 'react-native'
import React from 'react'
import { SafeAreaView } from 'react-native-safe-area-context'
import DateBlock from '@/components/DateBlock'
import MainTemplate from '@/components/mainApp/MainTemplate';
import images from '@/constants/images';

interface ButtonBlockProps{
    src: ImageSourcePropType,
    // handlePress: ()=>void
}

const ButtonBlock = ({src}:ButtonBlockProps) => {
  return (
    <TouchableOpacity
        // onPress={handlePress}
        style={styles.block}
    >
        <View style={styles.v2block}>
            <Image source={src} resizeMode='cover'></Image>
        </View>
    </TouchableOpacity>
  )
}

export default ButtonBlock

const styles = StyleSheet.create({
    block:{
        width: '30%', // Треть ширины
        aspectRatio: 1,
        backgroundColor: '#4CAC44',
        // flex:1,
        borderRadius:10,
        padding: 10,

    },
    v2block:{
        backgroundColor: "#565956",
        width: '100%',
        height: "100%",
        padding: 10,
        borderRadius:10,
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center'
    }
})