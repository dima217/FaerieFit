import { StatusBar, StyleSheet, Text, View, Image } from 'react-native'
import React from 'react'
import { SafeAreaView } from 'react-native-safe-area-context'
import DateBlock from '@/components/DateBlock'
import globalStyles from '../../constants/style';
import MainTemplate from '@/components/mainApp/MainTemplate';
import images from '@/constants/images';
import ButtonBlock from '@/components/ButtonBlock';


const Main = () => {
  return (
    <View style={{backgroundColor:'#474747', flex:1}}>
      <DateBlock/>
      {/* <Image src={images.apple}></Image> */}
      <View style={{
        paddingHorizontal: 15,
        marginVertical: 10
      }}>
        <View style={{
          width: '100%',
          height: 2,
          backgroundColor: '#4CAC44',
        }}></View>
        <Text style={{
          marginVertical: 35,
          color: "#4CAC44",
          fontSize: 30,
          textAlign: 'center',
          fontWeight: '500'
        }}>Добрый день, geralttop</Text>
        <View style={{
          width: '100%',
          height: 2,
          backgroundColor: '#4CAC44',
        }}></View>
      </View>
      <View style={{
        flexDirection: 'row', // Горизонтальное расположение
        flexWrap: 'wrap',
        gap: 10,
        marginVertical: 10,
        
        justifyContent: 'center',
        marginTop: 30
      }}>
        <ButtonBlock src={images.fire}/>
        <ButtonBlock src={images.human}/>
        <ButtonBlock src={images.mask}/>
        <ButtonBlock src={images.pill}/>
        <ButtonBlock src={images.love}/>
        <ButtonBlock src={images.yt}/>
        <ButtonBlock src={images.human_love}/>
        <ButtonBlock src={images.circle}/>
        <ButtonBlock src={images.cup}/>
      </View>
    </View>
  )
}

export default Main

const styles = StyleSheet.create({
  block:{

  }
})