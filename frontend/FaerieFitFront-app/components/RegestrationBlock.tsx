import { StyleSheet, Text, View, TouchableOpacity, Image } from 'react-native'
import React from 'react'
import style from '@/constants/style'
//import CheckBox from '@react-native-community/checkbox'
import images from '@/constants/images'

interface RegestrationBlockProps {
  isReg : boolean;
  childComponent: React.ReactNode;
  title: string
}

function OtherTypesReg(){
  return(
    <View style={styles.otherRegBlock}>
      <TouchableOpacity style={styles.otherRegButton}>
        <Image
          source={images.apple}
          style ={{width: 30, height: 30}}
        />
      </TouchableOpacity>

      <TouchableOpacity style={styles.otherRegButton}>
        <Image
          source={images.google}
          style ={{width: 30, height: 30}}
        />
      </TouchableOpacity>

      <TouchableOpacity style={styles.otherRegButton}>
        <Image
          source={images.telegram}
          style ={{width: 30, height: 30}}
        />
      </TouchableOpacity>
    </View>
  )
}

const RegestrationBlock = ({isReg, childComponent, title}:RegestrationBlockProps) => {
  return (
    <View style={styles.mainView}>
        <Text style={styles.title}>{title}</Text>
        <View style={styles.mainInfoBlock}>
          {childComponent}
        </View>
        {isReg ? <OtherTypesReg /> : null}
    </View>
  )
}

export default RegestrationBlock

const styles = StyleSheet.create({
    mainView:{
        backgroundColor: '#4CAC44',
        borderRadius: 20,
        width: '100%',
        alignItems: 'center',
        padding: 10
    },
    title:{

        fontSize: 24,
        color: '#565956',
        marginBottom: 15,
        marginTop: 15
    },
    mainInfoBlock:{
      width: '100%',
      borderRadius: 20,
      padding: 10,
      backgroundColor: '#B0E4ACB3',
      shadowColor: '#000',

    },
    mainInfoBlockText:{
      lineHeight: 22,
      fontSize: 18,
      textAlign: 'center',
      color: '#565956',
    },
    otherRegBlock:{
      marginTop: 10,
      flexDirection: 'row',        // Располагаем компоненты горизонтально
      justifyContent: 'space-between', // Отступы между компонентами
      width: '100%',  
      gap: 5
    },
    otherRegButton:{
      backgroundColor: '#B0E4AC',
      display: 'flex',
      justifyContent: 'center',
      alignItems: 'center',
      borderRadius: 10,
      flexGrow: 1,
      height: 50
    },

})