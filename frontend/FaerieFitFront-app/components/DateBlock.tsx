import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import images from '@/constants/images'
import { Image } from 'react-native';

const DateBlock = () => {
  return (
    <View style={{
      flexDirection: 'row',
      padding: 10,
      gap: 10,
      marginTop: 20
    }}>
      <View style={styles.firstV}>
        <View style={styles.secondV}>
          <View style={styles.thirdV}>
            <Text style={{
              textAlign: 'center',
              marginTop: 23,
              fontSize: 18,
              marginBottom: 0
            }}>Сегодня:</Text>
            <Text style={{
              textAlign: 'center',
              fontSize: 48,
              color: '#4CAC44'
            }}>14</Text>
            <Text style={{
              textAlign: 'center',
              fontSize: 13,
              color: '#4CAC44'
            }}>Октября, 2024</Text>
          </View>
          <View style={{
            justifyContent: 'space-between'
          }}>
            <Image source={images.calendar} resizeMode='cover'></Image>
            <Image source={images.cloacks} resizeMode='cover'></Image>
            <Image source={images.notes} resizeMode='cover'></Image>
          </View>
        </View>
      </View>
      <View style={styles.firstV}>
        <View style={styles.secondV}>
          <View style={{alignItems: 'center'}}>
            <Text style={{
              textAlign: 'center',
              color: '#b0e4ac',
              fontSize: 16
            }}>Факт дня:</Text>
            <Image source={images.leef} resizeMode='cover'></Image>
            <Text style={{
              textAlign: 'center',
              color: '#4CAC44'
            }}>В чайном листе содержится больший процент кофеина, чем в кофейных бобах</Text>
          </View>
        </View>
      </View>
    </View>
  )
}

export default DateBlock

const styles = StyleSheet.create({
  firstV:{
    height: 190,
    flexGrow: 1,
    backgroundColor: '#4CAC44',
    flex:1,
    borderRadius:10,
    padding: 10
  },
  secondV:{
    backgroundColor: "#565956",
    width: '100%',
    height: "100%",
    padding: 10,
    borderRadius:10,
    flexDirection: 'row',
    gap: 10
  },
  thirdV:{
    width: 125,
    height: "100%",
    backgroundColor: "#b0e4ac",
    borderRadius:10,
  },
})